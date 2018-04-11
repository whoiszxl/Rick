package com.whoiszxl.utils;

import com.whoiszxl.vo.ResultVO;

/**
 * 
 * @author whoiszxl
 *
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
