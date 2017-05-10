package com.spring.hibernate.service.impl;

import com.spring.hibernate.domain.DO.User;
import com.spring.hibernate.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by siyong.xu on 2017-05-05.
 */
@Transactional
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
}
