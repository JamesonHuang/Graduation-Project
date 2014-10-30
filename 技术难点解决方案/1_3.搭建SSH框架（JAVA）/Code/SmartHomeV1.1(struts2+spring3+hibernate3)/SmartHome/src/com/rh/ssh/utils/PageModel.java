package com.rh.ssh.utils;

import java.io.Serializable;
import java.util.List;

public class PageModel implements Serializable {

	private Integer currentPage = 1;
	private Integer pageSize = 10;
	private Integer beginQueryNumber;
	private Integer endQueryNumber;
	private Integer totalRows;
	private Integer totalPages;
	private List<?> list;
	private Boolean hasPreviousPage;
	private Boolean hasNextPage;
	private Integer previousPage;
	private Integer nextPage;
	private Integer start;

	public void init(int totalRows) {
		setTotalRows(totalRows);
		if ((totalRows % getPageSize()) == 0) {
			totalPages = totalRows / pageSize;
		} else {
			totalPages = totalRows / pageSize + 1;
		}
		if (getCurrentPage() == 1) {
			previousPage = 1;
		} else {
			previousPage = currentPage - 1;
		}
		if (currentPage.equals(totalPages)) {
			nextPage = currentPage;
		} else {
			nextPage = currentPage + 1;
		}
		calculatePage();
		setStart(getPageSize() * (getCurrentPage() - 1) + 1);
		setBeginQueryNumber((getCurrentPage() - 1) * getPageSize());
	}

	private void calculatePage() {
		if ((currentPage - 1) > 0) {
			hasPreviousPage = true;
		} else {
			hasPreviousPage = false;
		}
		if (currentPage >= totalPages) {
			hasNextPage = false;
		} else {
			hasNextPage = true;
		}
	}

	public Integer getPageSize() {
		if (pageSize == null) {
			setPageSize(10);
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		if (currentPage == null) {
			setCurrentPage(1);
		}
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Boolean getHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(Boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public Boolean getHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(Boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Integer getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(Integer previousPage) {
		this.previousPage = previousPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getBeginQueryNumber() {
		return beginQueryNumber;
	}

	public void setBeginQueryNumber(Integer beginQueryNumber) {
		this.beginQueryNumber = beginQueryNumber;
	}

	public Integer getEndQueryNumber() {
		return endQueryNumber;
	}

	public void setEndQueryNumber(Integer endQueryNumber) {
		this.endQueryNumber = endQueryNumber;
	}
}