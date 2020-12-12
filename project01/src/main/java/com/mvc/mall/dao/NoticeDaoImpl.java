package com.mvc.mall.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.mall.dto.NoticeDto;
import com.mvc.mall.dto.PagingDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private Logger logger = LoggerFactory.getLogger(NoticeDaoImpl.class);

	@Override
	public List<NoticeDto> list(PagingDto pagingdto) {
		List<NoticeDto> result = new ArrayList<NoticeDto>();
		try {
			result = sqlSession.selectList(NAMESPACE+"NoticeList", pagingdto);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl List");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public NoticeDto detail(int notice_no) {
		NoticeDto result = null;
		try {
			result = sqlSession.selectOne(NAMESPACE+"NoticeDetail",notice_no);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl Detail");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(NoticeDto dto) {
		int result = 0;
		try {
			result = sqlSession.insert(NAMESPACE+"NoticeInsert", dto);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl Insert");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(NoticeDto dto) {
		int result = 0;
		try {
			result = sqlSession.update(NAMESPACE+"NoticeUpdate", dto);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl Update");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int notice_no) {
		int result = 0;
		try {
			result = sqlSession.delete(NAMESPACE+"NoticeDelete", notice_no);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl Delete");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateCountView(int notice_no) {
		int result = 0;
		try {
			result = sqlSession.update(NAMESPACE+"NoticeCountView", notice_no);
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl updateContView");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int countNotice() {
		int result = 0;
		try {
			result = sqlSession.selectOne(NAMESPACE+"countNotice");
		} catch (Exception e) {
			logger.info("[ERROR] NoticeDaoImpl countNotice");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<NoticeDto> selectSearchTitle(String search_text, PagingDto pagingdto) {
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("notice_title", search_text);
		map.put("pagingdto", pagingdto);
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectSearchTitle",map);
		} catch (Exception e) {
			logger.info("[ERROR] selectSearchTitle DaoImpl");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<NoticeDto> selectSearchContent(String search_text, PagingDto pagingdto) {
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("notice_content", search_text);
		map.put("pagingdto", pagingdto);

		try {
			list = sqlSession.selectList(NAMESPACE+"selectSearchContent",map);
		} catch (Exception e) {
			logger.info("[ERROR] selectSearchContent DaoImpl");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int countSearchTitle(String search_text) {
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"searchcountTitle",search_text);
		} catch (Exception e) {
			logger.info("[ERROR] countSearchTitle DaoImpl");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int countSearchContent(String search_text) {
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"searchcountContent",search_text);
		} catch (Exception e) {
			logger.info("[ERROR] countSearchContent DaoImpl");
			e.printStackTrace();
		}
		return res;
	}

}
