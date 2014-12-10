package com.qianqian.refund.service.impl;

import com.qianqian.refund.dto.RefundExpressDTO;
import com.qianqian.refund.model.Refund;
import com.qianqian.refund.service.IRefundService;

/**
 * 
 * 本地退款接口的实现
 * 
 * @Project : order.maxtp   
 * @Program Name: com.qianqian.refund.service.impl.RefundServiceImpl.java 
 * @ClassName : RefundServiceImpl
 * @Author : lijingrui
 * @CreateDate ： 2014年7月28日 下午8:50:21 
 *
 */
public class RefundServiceImpl implements IRefundService {

	@Override
	public boolean addRefundForm(Refund newRefund) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRefundStateMaxtpIntervene(long refundId,
			int refundState) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRefundAppealState(long refundId, int appealState) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRefundExpressInfo(long refundId,
			RefundExpressDTO refundExpressDTO) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}

