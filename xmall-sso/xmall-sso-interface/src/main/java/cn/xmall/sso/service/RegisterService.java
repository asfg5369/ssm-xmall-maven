package cn.xmall.sso.service;

import cn.xmall.common.utils.XmallResult;
import cn.xmall.pojo.TbUser;

public interface RegisterService {

	XmallResult checkData(String param, int type);
	XmallResult register(TbUser user);
}
