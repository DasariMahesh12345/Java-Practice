package com.file.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.upload.model.DatabaseFile;
@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Integer> {

}
