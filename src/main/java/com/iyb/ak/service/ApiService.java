package com.iyb.ak.service;


import com.iyb.ak.entity.Api;
import com.iyb.ak.service.base.BaseService;

import java.util.List;

/**
 * Created by hezqi on 2017/6/26.
 */
public interface ApiService extends BaseService<Api, String> {
    Api create(Api api);

    Api update(Api entity);

    List<Api> getApis(Api api);
}