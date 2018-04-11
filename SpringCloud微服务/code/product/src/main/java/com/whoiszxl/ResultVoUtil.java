package com.whoiszxl;

import com.whoiszxl.vo.ResultVO;

/**
 * view object util
 * @author whoiszxl
 *
 */
public class ResultVoUtil {

	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO<>();
		resultVO.setData(object);
		resultVO.setCode(0);
		resultVO.setMsg("商品列表获取成功");
		return resultVO;
	}
	
}
