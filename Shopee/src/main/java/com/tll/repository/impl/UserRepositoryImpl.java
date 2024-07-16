package com.tll.repository.impl;

import com.tll.pojo.User;
import com.tll.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean isUserExist(Map<String, String> params) {
        Session session = Objects.requireNonNull(this.sessionFactory.getObject()).getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();

        String username = params.get("username");
        if(username != null && !username.isEmpty()) {
            Predicate predicate1 = criteriaBuilder.equal(root.get("username"), username);
            predicates.add(predicate1);
        }

        criteriaQuery.where(predicates.toArray(Predicate[]::new));

        Query<User> query = session.createQuery(criteriaQuery);

        return query.getSingleResult() == null;
    }
}
