package co.young.notice.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.young.notice.common.DataSource;
import co.young.notice.service.NoticeMapper;
import co.young.notice.service.NoticeService;
import co.young.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	
	
	@Override
	public List<NoticeVO> noticeSelectList() {
//		String sql = "SELECT * FROM NOTICE";
//		List<NoticeVO> notices = new ArrayList<NoticeVO>();
//		NoticeVO vo;
//		try {
//			conn = dao.getConnection();
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			while(rs.next()) {
//				vo = new NoticeVO();
//				vo.setNoticeId(rs.getInt("notice_id"));
//				vo.setNoticeWriter(rs.getString("notice_writer"));
//				vo.setNoticeTitle(rs.getString("notice_title"));
//				vo.setNoticeWdate(rs.getDate("notice_wdate"));
//				vo.setNoticeHit(rs.getInt("notice_hit"));
//				notices.add(vo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close();
//		}
//		return notices;
//		
		return map.noticeSelectList();
	}

//	private void close() {
//		try {
//			if(rs != null) rs.close();
//			if(psmt != null) psmt.close();
//			if(conn != null) conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
	
		return map.noticeDelete(vo);
	}

}
