package com.geneseeq.common.utils;


import com.geneseeq.common.pojo.packdata.SampleInfoResponseVO;
import net.sf.json.JSONArray;

public class BeanToJson {

	private static JSONArray jsonArray = null;

	public static String getJsonData(SampleInfoResponseVO sampleInfo) {
		jsonArray = JSONArray.fromObject(sampleInfo);
		String josndata = (String) jsonArray.toString().subSequence(1, jsonArray.toString().length() - 1);
		return josndata;
	}

}
