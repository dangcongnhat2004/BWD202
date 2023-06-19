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

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "chuyen_nganh")
public class ChuyenNganh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ten_chuyen_nganh")
    private String tenChuyenNganh;
    
    @ManyToMany(mappedBy = "chuyenNganhSet")
    private Set<ChuongTrinhDaoTao> chuongTrinhDaoTaoSet = new HashSet<>();
    
    @OneToMany(mappedBy = "chuyenNganh", cascade = CascadeType.ALL)
    private Set<DiemChuan> diemChuanSet = new HashSet<>();
    
    // Các getter và setter
}
