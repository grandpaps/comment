package org.imooc.dao;

import org.imooc.bean.Ad;

/**
 * @author 陈威
 */
public interface AdDtoTwoDao {
    /**
     * 添加广告
     * @param ad Ad
     * @return int
     */
    int addAd(Ad ad);
}
