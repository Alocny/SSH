package com.edu.ssh.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.struts2.ServletActionContext;

import com.edu.ssh.entity.Dish;
import com.edu.ssh.service.dish.IDishService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class DishAction implements ModelDriven<Dish> {
	private Dish dish;
	private IDishService dishService;

	private Integer currentPage2;

	private File dishimg;
	private String dishimgFileName;

	private String keyword;

	private File myfile;
	private String myfileFileName;

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public File getDishimg() {
		return dishimg;
	}

	public void setDishimg(File dishimg) {
		this.dishimg = dishimg;
	}

	public String getDishimgFileName() {
		return dishimgFileName;
	}

	public void setDishimgFileName(String dishimgFileName) {
		this.dishimgFileName = dishimgFileName;
	}

	public Integer getCurrentPage2() {
		return currentPage2;
	}

	public void setCurrentPage2(Integer currentPage2) {
		this.currentPage2 = currentPage2;
	}

	public IDishService getDishService() {
		return dishService;
	}

	public void setDishService(IDishService dishService) {
		this.dishService = dishService;
	}

	@Override
	public Dish getModel() {
		if (dish == null)
			dish = new Dish();
		return dish;
	}

	private void showByPage(int pageSize) {
		ServletActionContext.getResponse().setContentType(
				"text/html;charset=utf-8");
		try {
			ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(currentPage2);
		if (currentPage2 == null) {
			currentPage2 = 1;
		}
		int pageTotal2 = dishService.getPageTotal(pageSize);
		if (currentPage2 < 1) {
			currentPage2 = 1;
		}
		if (currentPage2 > pageTotal2) {
			currentPage2 = pageTotal2;
		}
		ActionContext.getContext().getSession()
				.put("currentPage2", currentPage2);
		ActionContext.getContext().getSession().put("pageTotal2", pageTotal2);
		List<Dish> dishes = dishService.getDishsByPage(currentPage2, pageSize);
		ActionContext.getContext().getSession().put("dishes", dishes);
	}

	public String list() {
		showByPage(4);
		return "list";
	}

	public String add() {
		String path = ServletActionContext.getServletContext().getRealPath(
				"/imgs");
		File file = new File(path, dishimgFileName);
		try {
			FileUtils.copyFile(dishimg, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dish.setImg("../imgs/" + dishimgFileName);

		dishService.save(dish);

		return "success";
	}

	public String delete() {
		dishService.delete(dish);
		return "success";
	}

	public String update() {
		String path = ServletActionContext.getServletContext().getRealPath(
				"/imgs");
		File file = new File(path, dishimgFileName);
		try {
			FileUtils.copyFile(dishimg, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dish.setImg("../imgs/" + dishimgFileName);

		dishService.update(dish);

		return "success";
	}

	public String search() {

		Long count = dishService.getCountByKey(keyword);
		List<Dish> dishes = dishService.getDishsByKey(keyword);
		ActionContext.getContext().getSession().put("countbykeydish", count);
		ActionContext.getContext().getSession().put("showbykeydishes", dishes);
		return "search";
	}

	public String export() {
		List<Dish> dishes = dishService.getDishs();
		Iterator iter = dishes.iterator();
		// 目标文件
		File path = new File("d:\\Dish");
		if (!path.exists())
			path.mkdir();

		File file = new File(path, "dishes.xls");
		FileOutputStream fOut = null;
		String[] title = { "ID", "NAME", "DESCRIPTION", "TXT", "IMG",
				"ISRECOMMENDED", "PRICE" };
		try {
			// 创建新的Excel工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 创建工作表，并指定名字
			HSSFSheet sheet = workbook.createSheet("dishes");
			// 创建1行7列的单元格
			// 先创建一行
			int rowNum = 0; // 行标
			int colNum = 0; // 列标
			HSSFRow row = sheet.createRow(rowNum);
			HSSFCell cell = null;
			// 创建7列,并赋值为标题
			for (colNum = 0; colNum < 7; colNum++) {
				cell = row.createCell(colNum);
				cell.setCellValue(title[colNum]);
			}

			// 从第二行开始
			rowNum = 1;
			colNum = 0;
			// 根据有多少行数据就创建多少行
			while (iter.hasNext()) {
				row = sheet.createRow(rowNum++);
				Dish dish = (Dish) iter.next();
				colNum = 0;
				cell = row.createCell(colNum++);
				cell.setCellType(CellType.NUMERIC);
				cell.setCellValue(dish.getId());
				cell = row.createCell(colNum++);
				cell.setCellType(CellType.STRING);
				cell.setCellValue(dish.getName());
				cell = row.createCell(colNum++);
				cell.setCellType(CellType.STRING);
				cell.setCellValue(dish.getDescription());
				cell = row.createCell(colNum++);
				cell.setCellType(CellType.STRING);
				cell.setCellValue(dish.getTxt());
				cell = row.createCell(colNum++);
				cell.setCellType(CellType.STRING);
				cell.setCellValue(dish.getImg());
				cell = row.createCell(colNum++);
				cell.setCellType(CellType.STRING);
				cell.setCellValue(dish.getIsRecommended() + "");
				cell = row.createCell(colNum++);
				cell.setCellType(CellType.NUMERIC);
				cell.setCellValue(dish.getPrice());
			}
			// 新建输出文件流
			fOut = new FileOutputStream(file);
			// 把相应的Excel工作簿存盘
			workbook.write(fOut);
			fOut.flush();// 刷新缓存
			// 关闭资源
			fOut.close();

			ActionContext.getContext().getSession()
					.put("exportinfo", "菜品数据导出成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fOut != null) {
				try {
					fOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return "success";
	}

	private boolean isRowEmpty(HSSFRow row) {
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			HSSFCell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != HSSFCell.CELL_TYPE_BLANK)
				return false;
		}
		return true;
	}

	public String dimport() {

		// 目标文件
		File path=new File("d://Dish");
		if(!path.exists())
			path.mkdir();
		 
		File file = new File(path, myfileFileName);
		
		try {
			FileUtils.copyFile(myfile, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream in = null;
		try {
			// 创建对Excel工作簿文件的引用
			in = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(in);
			// 创建对工作表的引用
			HSSFSheet sheet = workbook.getSheetAt(0);
			HSSFRow row = null;
			HSSFCell cell = null;
			int rowNum = 0;// 行标
			int colNum = 0;// 列标
			// 去掉标题从第二行开始
			rowNum = 1;
			//row = sheet.getRow(rowNum);// 取出第一行
			// 判断是否为空
			Dish dish = new Dish();
			while (!isRowEmpty((row=sheet.getRow(rowNum)))) {
				rowNum++;
				colNum = 0;
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setId(Integer.parseInt(cell.getStringCellValue()));
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setName(cell.getStringCellValue());
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setDescription(cell.getStringCellValue());
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setTxt(cell.getStringCellValue());
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setImg(cell.getStringCellValue());
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setIsRecommended(cell.getStringCellValue().toCharArray()[0]);
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setPrice(Double.parseDouble(cell.getStringCellValue()));
				dishService.save(dish);

			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return "success";
	}
}
