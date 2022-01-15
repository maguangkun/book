package com.mgk.account.book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*","com.mgk.account.book.modules.*.dao"})
@MapperScan({"com.mgk.account.book.modules.*.dao"})
@SpringBootApplication
//@ComponentScan("com.gitee.sunchenbin.mybatis.actable.manager.*")
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

}
