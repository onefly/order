<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<script type="text/javascript">
	$(function(){
		_init_area();
	})
</script>
 	<c:forEach items="${bo.receiverList}" var="rece" varStatus="s">
          <p>
          
          	<input type="hidden" value="${rece.recieveAddressId}" id="addressId_${rece.recieveAddressId}"/>
          	<input type="hidden" value="${rece.recieveName}" id="recieveName_${rece.recieveAddressId}"/>
          	<input type="hidden" value="${rece.recieveMobilephone}" id="recieveMobilephone_${rece.recieveAddressId}"/>
          	<input type="hidden" value="${rece.recieveTelephone}" id="recieveTelephone_${rece.recieveAddressId}"/>
          	<input type="hidden" value="${rece.address}" id="address_${rece.recieveAddressId}"/>
          	<input type="hidden" value="${rece.province}" id="province_${rece.recieveAddressId}"/>
          	<input type="hidden" value="${rece.city}" id="city_${rece.recieveAddressId}"/>
          	<input type="hidden" value="${rece.district}" id="district_${rece.recieveAddressId}"/>
          	<input type="hidden" value="${rece.provinceName}" id="provinceName_${rece.recieveAddressId}"/>
          	<input type="hidden" value="${rece.cityName}" id="cityName_${rece.recieveAddressId}"/>
          	<input type="hidden" value="${rece.districtName}" id="districtName_${rece.recieveAddressId}"/>
          <c:if test="${bo.receiver.recieveAddressId == rece.recieveAddressId}">
           <input type="radio" name="receiver" id="radio_${rece.recieveAddressId}" checked="checked"  onclick="hideNewAddress('${rece.recieveAddressId}')"  value="${rece.recieveAddressId}" />
            </c:if>
            <c:if test="${bo.receiver.recieveAddressId != rece.recieveAddressId}">
           <input type="radio" name="receiver" id="radio_${rece.recieveAddressId}"  onclick="hideNewAddress('${rece.recieveAddressId}')"  value="${rece.recieveAddressId}" />
            </c:if>
            <label for="radio"><span>${rece.recieveName}</span><span>${rece.provinceName}${rece.cityName}${rece.districtName}${rece.address}</span>
            <span>${rece.recieveMobilephone}</span><span>${rece.recieveTelephone}</span>
             <a href="javascript:editAddress('${rece.recieveAddressId}')" class="yellow">［修改］</a></label>
          </p>
          </c:forEach>
          <p>
          <c:if test="${fn:length(bo.receiverList) < 3 }">
           <input type="radio" name="receiver" id="radio" value="radio" onclick="showNewAddress()"/>
           <label for="radio"><em>使用新地址</em></label>
           </c:if>
           <form action="" id="ReceiverForm">
           <ul class="width740" style="display:none" id="newAddressDiv">
            <li>
                <label for="textfield" class="fl_lft"><em class="red">＊</em>收货人：</label>
                <input type="hidden"  id="newaddressId"/>
                <input type="text" name="recieveName" maxlength="10" id="newrecieveName" class="input145" />
            </li>
            <li>
            <label for="textfield" class="fl_lft"><em class="red">＊</em>所在地区：</label>
            
            <input type="hidden" name="provinceName" id="provinceName" value="${recAddr.provinceName}"/>
			<input type="hidden" name="cityName" id="cityName" value="${recAddr.cityName}"/>
			<input type="hidden" name="districtName" id="districtName" value="${recAddr.districtName}"/>
        
              <select name="province" id="s_province" class="select120">
								<option>
									请选择
								</option>
				</select>
				<select name="city" id="s_city" class="select120">
								<option>
									请选择
								</option>
				</select>
				<select name="district" id="s_county" class="select120">
								<option>
									请选择
								</option>
				</select>
              
            </li>
            <li>
                <label for="textfield" class="fl_lft"><em class="red">＊</em>详细地址：</label>
                <input type="text" name="address" id="newaddress" maxlength="100" class="input470" />
            </li>
            <li>
             <label for="textfield" class="fl_lft"><em class="red">＊</em>手机号码：</label>
             <input type="text" name="recieveMobilephone" maxlength="11" id="newrecieveMobilephone" class="input180" />
             <label for="textfield" class="fl_lft"><em class="red">＊</em>固定电话：</label>
             <input type="text" name="recieveTelephone" maxlength="13" id="newrecieveTelephone" class="input180" />
            
            </li>
            
           </ul>
           <input type="hidden" name="recieveAddressId"  id="currentReceiver" value="${bo.receiver.recieveAddressId}"/>
           </form>
          </p>