package com.hunter.base.vo;import com.alibaba.fastjson.JSONObject;import com.alibaba.fastjson.serializer.SerializerFeature;import com.github.pagehelper.PageInfo;import com.google.common.collect.Lists;import com.google.common.collect.Maps;import java.util.Map;/** * @Author zhangcl * @Date 17/5/7  上午10:28 */public class ResponseData {    private PageInfo pageInfo;    public ResponseData(PageInfo pageInfo) {        this.pageInfo = pageInfo;    }    public String getResultJson(RequestData requestData) {        Map map = Maps.newHashMap();        map.put("data", pageInfo.getList() == null ? Lists.newArrayList() : pageInfo.getList());        map.put("recordsTotal", pageInfo.getTotal());        map.put("recordsFiltered", pageInfo.getTotal());        map.put("draw", requestData.getDraw());        //当map中的value值为null时,得到的json串中没有此key和value        String json = JSONObject.toJSONString(map, SerializerFeature.PrettyFormat);        return json;    }}