package com.openlgu.psgc.dto;

public class PsgcImportResponse {
	private String filename;
	private int size;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "PsgcImportResponse [filename=" + filename + ", size=" + size + "]";
	}

}
