package cn.zack.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zack
 * user实体类
 * 使用@Entity声明为一个实体类
 * 使用@Table声明表映射关系
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    /**
     * 声明此字段为数据库主键, 主键维护方式交由程序控制
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long userId;

    private String username;
    private String password;
    private String gender;
    private String address;
}
