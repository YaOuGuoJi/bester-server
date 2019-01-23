package com.xianbester.service.task;

import com.xianbester.api.constant.BlockChainParameters;
import com.xianbester.api.dto.BigEventDTO;
import com.xianbester.service.dao.BigEventDao;
import com.xianbester.service.dao.CameraMapper;
import com.xianbester.service.dao.RecordMapper;
import com.xianbester.service.entity.BigEventEntity;
import com.xianbester.service.entity.CountEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangqiang
 * @date 2019-01-22
 */
@Component
public class FinishBigEventTask {

    @Resource
    private BigEventDao bigEventDao;

    @Resource
    private RecordMapper recordMapper;

    @Resource
    private CameraMapper cameraMapper;

    @Scheduled(cron = BlockChainParameters.FINISHED_EVENT)
    public void finishEvent() {
        Date now = new Date();
        List<BigEventEntity> notFinishedEvent = bigEventDao.findNotFinishedEvent(BigEventDTO.NOT_FINISHED);
        if (!CollectionUtils.isEmpty(notFinishedEvent)) {
            for (BigEventEntity entity : notFinishedEvent) {
                Date startTime = entity.getBeginTime();
                Date endTime = entity.getEndTime();
                if (now.after(endTime)) {
                    updateEventJoinNum(entity, startTime, endTime);
                    bigEventDao.updateByUniqueField("Finish", BigEventDTO.FINISHED + "", entity.getId());
                }
                if (now.after(startTime) && now.before(endTime)) {
                    updateEventJoinNum(entity, startTime, now);
                }
            }
        }
    }

    private void updateEventJoinNum(BigEventEntity entity, Date startTime, Date endTime) {
        String location = entity.getLocation();
        String[] locationIds = location.split(",");
        List<String> locationIdList = Stream.of(locationIds).collect(Collectors.toList());
        List<Integer> cameraIdList = cameraMapper.findCameraIdListByLocationIds(locationIdList);
        CountEntity countEntity = recordMapper.checkNumberOfParticipantsInterval(cameraIdList, startTime, endTime);
        int maleNum = countEntity.getId() == null ? 0 : countEntity.getId();
        int femaleNum = countEntity.getResult() == null ? 0 : countEntity.getResult();
        bigEventDao.updateByUniqueField("EventJoinNum", maleNum + femaleNum + "", entity.getId());
    }

}
