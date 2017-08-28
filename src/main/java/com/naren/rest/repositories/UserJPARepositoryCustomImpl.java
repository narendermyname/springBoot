/**
 * 
 */
package com.naren.rest.repositories;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.naren.rest.dto.User;

/**
 * @author ntanwa
 *
 */
public class UserJPARepositoryCustomImpl implements UserJpaRepository {

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Sort)
	 */
	@Override
	public List<User> findAll(Sort sort) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(java.lang.Iterable)
	 */
	@Override
	public List<User> findAll(Iterable<Long> ids) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#save(java.lang.Iterable)
	 */
	@Override
	public <S extends User> List<S> save(Iterable<S> entities) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#flush()
	 */
	@Override
	public void flush() {
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#saveAndFlush(java.lang.Object)
	 */
	@Override
	public <S extends User> S saveAndFlush(S entity) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#deleteInBatch(java.lang.Iterable)
	 */
	@Override
	public void deleteInBatch(Iterable<User> entities) {
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#deleteAllInBatch()
	 */
	@Override
	public void deleteAllInBatch() {
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#getOne(java.io.Serializable)
	 */
	@Override
	public User getOne(Long id) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Example, org.springframework.data.domain.Sort)
	 */
	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<User> findAll(Pageable pageable) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@Override
	public <S extends User> S save(S entity) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	@Override
	public User findOne(Long id) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#exists(java.io.Serializable)
	 */
	@Override
	public boolean exists(Long id) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	@Override
	public long count() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Long id) {
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(User entity) {
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<? extends User> entities) {
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	@Override
	public void deleteAll() {
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#findOne(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends User> S findOne(Example<S> example) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#findAll(org.springframework.data.domain.Example, org.springframework.data.domain.Pageable)
	 */
	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#count(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends User> long count(Example<S> example) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#exists(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends User> boolean exists(Example<S> example) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#findByRolesLike(java.lang.String)
	 */
	@Override
	public List<User> findByRolesLike(String roleStartWith) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#countByEmailLike(java.lang.String)
	 */
	@Override
	public long countByEmailLike(String roleName) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#findByNameAndEmailLike(java.lang.String, java.lang.String)
	 */
	@Override
	public List<User> findByNameAndEmailLike(String name, String email) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#findByNameIsOrEmailEquals(java.lang.String, java.lang.String)
	 */
	@Override
	public List<User> findByNameIsOrEmailEquals(String name, String email) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#findAll()
	 */
	@Override
	public List<User> findAll() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#findByNameNotLike(java.lang.String)
	 */
	@Override
	public List<User> findByNameNotLike(String name) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#findByNameLike(java.lang.String)
	 */
	@Override
	public List<User> findByNameLike(String name) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#findByNameStartingWith(java.lang.String)
	 */
	@Override
	public List<User> findByNameStartingWith(String name) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#findByEmail(java.lang.String)
	 */
	@Override
	public User findByEmail(String email) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#queryByNameAndActiveUser(java.lang.String, int, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<User> queryByNameAndActiveUser(String name, int active, Pageable page) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#queryByActiveUser(int, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<User> queryByActiveUser(int active, Pageable page) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#queryByName(java.lang.String)
	 */
	@Override
	public User queryByName(String name) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#update(java.lang.String)
	 */
	@Override
	public int update(String lastName) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.naren.rest.repositories.UserJpaRepository#queryByLastName(java.lang.String)
	 */
	@Override
	public List<User> queryByLastName(String lastName) {
		return null;
	}

}
