package com.file.upload.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class DatabaseFile {
	   
	    //@GeneratedValue(generator = "uuid")
	    //@GenericGenerator(name = "uuid", strategy = "uuid2")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Id
	    private Integer id;

	    private String fileName;

	    private String fileType;

	    @Lob
	    private byte[] data;

	    public DatabaseFile() {

	    }

	    public DatabaseFile(String fileName, String fileType, byte[] data) {
	        this.fileName = fileName;
	        this.fileType = fileType;
	        this.data = data;
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}

		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}

	  

}
