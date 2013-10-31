package org.dayatang.hrm.organisation.domain;

import com.dayatang.spring.factory.SpringInstanceProvider;
import org.junit.After;
import org.junit.Before;

import com.dayatang.domain.InstanceFactory;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * 集成测试基类。用于管理持久化和IoC基础设施
 * 
 * @author yyang
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AbstractIntegrationTest {

    @Inject
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        SpringInstanceProvider provider = new SpringInstanceProvider(applicationContext);
        InstanceFactory.setInstanceProvider(provider);
    }

    @After
    public void tearDown() throws Exception {
        InstanceFactory.setInstanceProvider(null);
    }

}
