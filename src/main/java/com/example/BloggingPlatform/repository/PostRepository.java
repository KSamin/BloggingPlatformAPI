package com.example.BloggingPlatform.repository;

import com.example.BloggingPlatform.model.Post;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface PostRepository extends MongoRepository<Post, String> {
//    @Override
//    public <S extends Post> S insert(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Post> List<S> insert(Iterable<S> entities) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends Post> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Post> List<S> findAll(Example<S> example) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends Post> List<S> findAll(Example<S> example, Sort sort) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends Post> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Post> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Post> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends Post, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//
//    @Override
//    public <S extends Post> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Post> List<S> saveAll(Iterable<S> entities) {
//        return List.of();
//    }
//
//    @Override
//    public Optional<Post> findById(String s) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(String s) {
//        return false;
//    }
//
//    @Override
//    public List<Post> findAll() {
//        return List.of();
//    }
//
//    @Override
//    public List<Post> findAllById(Iterable<String> strings) {
//        return List.of();
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(String s) {
//
//    }
//
//    @Override
//    public void delete(Post entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends String> strings) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Post> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public List<Post> findAll(Sort sort) {
//        return List.of();
//    }
//
//    @Override
//    public Page<Post> findAll(Pageable pageable) {
//        return null;
//    }
    @Query("{ '$or': [ " +
            "{ 'title': { $regex: ?0, $options: 'i' } }, " +
            "{ 'content': { $regex: ?0, $options: 'i' } }, " +
            "{ 'tags': { $regex: ?0, $options: 'i' } } " +
            "] }")
    public List<Post> searchPosts(String query);

}
