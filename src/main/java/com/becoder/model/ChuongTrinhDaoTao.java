package com.becoder.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "chuong_trinh_dao_tao")
public class ChuongTrinhDaoTao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ten_chuong_trinh_dao_tao")
    private String tenChuongTrinhDaoTao;
    
    @ManyToOne
    @JoinColumn(name = "truong_id")
    private Truong truong;
    
    @ManyToMany
    @JoinTable(name = "chuyen_nganh_chuong_trinh_dao_tao",
            joinColumns = @JoinColumn(name = "chuong_trinh_dao_tao_id"),
            inverseJoinColumns = @JoinColumn(name = "chuyen_nganh_id"))
    private Set<ChuyenNganh> chuyenNganhSet = new HashSet<>();
    
    // Các getter và setter
}