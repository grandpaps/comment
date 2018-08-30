package org.imooc.service.impl;

import org.imooc.bean.Ad;
import org.imooc.dao.AdDtoTwoDao;
import org.imooc.dto.AdDtoTwo;
import org.imooc.service.AdTwoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @author 陈威
 */
@Service
public class AdTwoServiceImpl implements AdTwoService {

    @Autowired
    private AdDtoTwoDao adDtoTwoDao;
    @Value("${adImage.savePath}")
    private String savePath;
    @Override
    public boolean insertAd(AdDtoTwo adDtoTwo) {
        Ad ad = new Ad();
        BeanUtils.copyProperties(adDtoTwo,ad);
        if(adDtoTwo.getMultipartFile()!=null && adDtoTwo.getMultipartFile().getSize()>0) {
            String fileName = System.currentTimeMillis() + "_" + adDtoTwo.getMultipartFile().getOriginalFilename();
            File file = new File(savePath + fileName);
            File fileFolder = new File(savePath);
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            try {
                adDtoTwo.getMultipartFile().transferTo(file);
                ad.setImgFileName(fileName);
                adDtoTwoDao.addAd(ad);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        else{
            return false;
        }
    }
}
