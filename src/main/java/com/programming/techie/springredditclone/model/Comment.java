package com.programming.techie.springredditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotEmpty
    private String text;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private Post post;

    /***
     * https://gpcoder.com/6338-cac-annotation-cua-hibernate/#FetchTypeLAZY
     * FetchType.LAZY
     * https://gpcoder.com/6338-cac-annotation-cua-hibernate/#FetchTypeEAGER
     * FetchType.EAGER
     *
     * Lưu ý: nên sử dụng LAZY thay vì EAGER vì lý do hiệu năng chương trình.
     */

    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}
