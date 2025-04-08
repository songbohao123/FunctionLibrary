package com.example.gittestdemo;

/**
 * 首页列表功能常量
 */
public enum Constant {
    document("文档"), kotlin("kotlin"),movie("影视"),animation("动画"),particle("粒子");
    public final String mName;

    Constant(String type) {
        this.mName = type;
    }

}
