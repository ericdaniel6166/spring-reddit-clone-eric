package com.programming.techie.springredditclone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    /***
     * https://gpcoder.com/3806-gioi-thieu-thu-vien-pho-bien-cua-java-project-lombok/#Builder_Pattern_voi_Builder_trong_Project_Lombok
     * Builder Pattern với @Builder trong Project Lombok
     */

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long postId;

    /***
     * https://gpcoder.com/6338-cac-annotation-cua-hibernate/#GeneratedValue
     * GenerationType.IDENTITY
     * GenerationType.SEQUENCE
     * GenerationType.TABLE
     */

    @NotBlank(message = "Post Name cannot be empty or Null")
    private String postName;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;

    /***
     * https://gpcoder.com/6338-cac-annotation-cua-hibernate/#Lob
     * @Lob thường chú thích cùng với @Column để nói rằng cột đó có kiểu BLOB hoặc CLOB.
     * Trong một số Database có phân biệt TINY, MEDIUM, LARGE BLOB/CLOB, còn một số database thì không.
     * Phần tử length trong @Column trong trường hợp này sẽ quyết định nó map vào BLOB/ CLOB nào.
     * Trong trường hợp cho phép BLOB/CLOB tối đa hãy để length = Integer.MAX_VALUE.
     */

    private Integer voteCount = 0;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Subreddit subreddit;
}
