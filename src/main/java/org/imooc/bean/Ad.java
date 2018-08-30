package org.imooc.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 这里Long用封装类型，而不用基本类型
 *  1：有的数据可能在数据库中为空（null)值，
 *   那么如过是基本数据类型的画在映射的时候会报错，用封装类型就允许为空
 *   2:未来在写sql语句可能会根据这些字段来判断，动态拼接sql语句，如果是基本数据类型不好用
 */
@JsonInclude(Include.NON_NULL)
public class Ad extends BaseBean {

    private Long id;
    private String title;
    private String imgFileName;
    private String link;
    private Long weight;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImgFileName() {
        return imgFileName;
    }
    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getWeight() {
        return weight;
    }
    public void setWeight(Long weight) {
        this.weight = weight;
    }
    
}