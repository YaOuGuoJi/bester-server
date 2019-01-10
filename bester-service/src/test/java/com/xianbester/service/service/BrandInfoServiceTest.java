package com.xianbester.service.service;

import com.xianbester.api.dto.BrandInfoDTO;
import com.xianbester.api.service.BrandInfoService;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandInfoServiceTest {

    @Resource
    private BrandInfoService brandInfoService;

    @Test
    public void selectByIds(){
        List<Integer> ids = Lists.newArrayList(1,2,3);
        List<BrandInfoDTO> brandInfoDTOList = brandInfoService.selectByIdList(ids);
        Assert.assertEquals(brandInfoDTOList.size(), 3);
    }
}
