package com.qianqian.refund.service;

import com.qianqian.refund.dto.RefundExpressDTO;
import com.qianqian.refund.model.Refund;

/**
 * 
 * 本地退款接口
 * 
 * @Project : order.maxtp   
 * @Program Name: com.qianqian.refund.service.IRefundService.java 
 * @ClassName : IRefundService
 * @Author : lijingrui
 * @CreateDate ： 2014年7月28日 下午8:35:47 
 *
 */
public interface IRefundService {
	
	public boolean addRefundForm(Refund newRefund) throws Exception;
	
	public boolean updateRefundStateMaxtpIntervene(long refundId, int refundState);
	
	public boolean updateRefundAppealState(long refundId, int appealState);
	
	public boolean updateRefundExpressInfo(long refundId, RefundExpressDTO refundExpressDTO);
	
	
}