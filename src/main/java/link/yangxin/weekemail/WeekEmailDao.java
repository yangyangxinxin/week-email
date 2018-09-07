package link.yangxin.weekemail;

import link.yangxin.weekemail.dal.entity.WeekEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yangxin
 * @date 2018/9/7
 */
@Repository
public interface WeekEmailDao extends JpaRepository<WeekEmail,Long> {
}