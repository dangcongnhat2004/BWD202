package com.becoder.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "truong")
public class Truong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ten_truong")
    private String tenTruong;
    
    @Column(name = "he_dao_tao")
    private String heDaoTao;
    
    @OneToMany(mappedBy = "truong", cascade = CascadeType.ALL)
    private Set<DiemChuan> diemChuanSet = new HashSet<>();
    
    @OneToMany(mappedBy = "truong", cascade = CascadeType.ALL)
    private Set<ChuongTrinhDaoTao> chuongTrinhDaoTaoSet = new HashSet<>();
    
    // Các getter và setter
}