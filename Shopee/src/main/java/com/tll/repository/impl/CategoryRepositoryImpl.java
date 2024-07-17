package com.tll.repository.impl;

import com.tll.pojo.Category;
import com.tll.repository.CategoryRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Category> getCategories() {
        Session s = Objects.requireNonNull(this.sessionFactory.getObject()).getCurrentSession();
        Query q = s.createQuery("From Category");
        return q.getResultList();
    }
}
