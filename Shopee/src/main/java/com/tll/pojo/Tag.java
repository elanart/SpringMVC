package com.tll.pojo;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "tagcol", length = 45)
    private String tagcol;

    @OneToMany(mappedBy = "tag")
    private Set<ProdTag> prodTags = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagcol() {
        return tagcol;
    }

    public void setTagcol(String tagcol) {
        this.tagcol = tagcol;
    }

    public Set<ProdTag> getProdTags() {
        return prodTags;
    }

    public void setProdTags(Set<ProdTag> prodTags) {
        this.prodTags = prodTags;
    }

}