package ysw.dao;

import ysw.exception.SystemException;
import ysw.model.DictionaryTag;
import ysw.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/12 22:56
 * @Version
 **/
public class DictionaryDAO {
    public static List<DictionaryTag> query(String key) {
        List<DictionaryTag> tags = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select concat(d.dictionary_key, dt.dictionary_tag_key) dictionary_tag_key," +
                    "       dt.dictionary_tag_value" +
                    " from dictionary d" +
                    "         join dictionary_tag dt on d.id = dt.dictionary_id" +
                    " where d.dictionary_key = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            rs=ps.executeQuery();
            while (rs.next()) {
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(rs.getString("dictionary_tag_key"));
                tag.setDictionaryTagValue(rs.getString("dictionary_tag_value"));
                tags.add(tag);
            }
        } catch (SQLException e) {
            throw new SystemException("0002", "查询数据字典信息出错", e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return tags;

    }
}
