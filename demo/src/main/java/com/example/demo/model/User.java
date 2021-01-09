package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("user.user")
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @Version //乐观锁Version注解
    private Integer version;


    /**
     * 从数据库中直接移除 逻辑删除 ：在数据库中没有被移除，而是通过一个变量来让它失效！
     * deleted = 0 => deleted = 1 管理员可以查看被删除的记录！防止数据的丢失，类似于回收站！
     */
    @TableLogic //逻辑删除
    private Integer deleted;
}
