package cn.xmall.search.service;

import cn.xmall.common.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String keyword, int page, int rows)  throws Exception;
}
