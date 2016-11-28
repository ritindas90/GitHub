package com.ritin.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ritin.model.Inventory;
import com.ritin.model.SampleData;

public class FileServiceHelper {
	private  final int channelCell = 0;
	private  final int sessionCell = 1;
	private  final int roomTypeCell = 2;
	private  final int mealPlanCell = 3;
	private  final int maxOcuupancyCell = 4;
	private  final int priceCell = 5;
	public File exportToExcel(){
		System.out.println("Begin DataExportHelper");
		try{
			Row row = null;
	        Cell cell = null;
	        int rownum =0;
			//Blank workbook
	        XSSFWorkbook workbook = new XSSFWorkbook(); //Create a blank sheet
	        XSSFSheet sheet = workbook.createSheet("Resort Configuration Data");
	        //This data needs to be written 
	        Map<String, Map<String, Map<String, Map<String, Inventory>>>> channelMap = SampleData.returnTestData();
	        
	        //Write Header Column
	        row = sheet.createRow(rownum++);
	        cell = row.createCell(channelCell);
	        insertCellValue(cell,"Channel");
	        cell = row.createCell(sessionCell);
	        insertCellValue(cell,"Session");
	        cell = row.createCell(roomTypeCell);
	        insertCellValue(cell,"RoomType");
	        cell = row.createCell(mealPlanCell);
	        insertCellValue(cell,"MealPlan");
	        cell = row.createCell(maxOcuupancyCell);
	        insertCellValue(cell,"MaxOccupancy");
	        cell = row.createCell(priceCell);
	        insertCellValue(cell,"Price");
	        
	        
	        //Iterate over data and write to sheet
	        int channelCount = 0;
	        row = sheet.createRow(rownum);
	        for (Map.Entry<String, Map<String, Map<String, Map<String, Inventory>>>> channelEntry : channelMap.entrySet()) {
	            Map<String , Map<String, Map<String,Inventory>>> sessionMap = channelEntry.getValue();
	            if(channelCount++>0){
	            	row = sheet.createRow(++rownum);
	            }
	            row = sheet.createRow(rownum);
	            cell = row.createCell(channelCell);
	            insertCellValue(cell,channelEntry.getKey());
	            int sessionCount = 0;
	            for (Map.Entry<String, Map<String, Map<String, Inventory>>> sessionEntry : sessionMap.entrySet()) {
		            Map<String, Map<String,Inventory>> roomTypeMap = sessionEntry.getValue();
		            if(sessionCount++>0){
		            	row = sheet.createRow(++rownum);
		            }
		            cell = row.createCell(channelCell);
		            insertCellValue(cell,channelEntry.getKey());
		            cell = row.createCell(sessionCell);
		            insertCellValue(cell,sessionEntry.getKey());
		            int roomTypeCount = 0;
		            for (Map.Entry<String, Map<String, Inventory>> roomTypeEntry : roomTypeMap.entrySet()) {
			            Map<String,Inventory> mealPlanMap = roomTypeEntry.getValue();
			            if(roomTypeCount++>0){
			            	row = sheet.createRow(++rownum);
			            }
			            cell = row.createCell(channelCell);
			            insertCellValue(cell,channelEntry.getKey());
			            cell = row.createCell(sessionCell);
			            insertCellValue(cell,sessionEntry.getKey());
			            cell = row.createCell(roomTypeCell);
			            insertCellValue(cell,roomTypeEntry.getKey());
			            int mealPlanCount = 0;
			            for (Map.Entry<String, Inventory> mealPlanEntry : mealPlanMap.entrySet()) {
			            	Inventory inventory = mealPlanEntry.getValue();
				            if(mealPlanCount++>0){
				            	row = sheet.createRow(++rownum);
				            }
				            cell = row.createCell(channelCell);
				            insertCellValue(cell,channelEntry.getKey());
				            cell = row.createCell(sessionCell);
				            insertCellValue(cell,sessionEntry.getKey());
				            cell = row.createCell(roomTypeCell);
				            insertCellValue(cell,roomTypeEntry.getKey());
				            cell = row.createCell(mealPlanCell);
				            insertCellValue(cell,mealPlanEntry.getKey());
				            cell = row.createCell(maxOcuupancyCell);
				            insertCellValue(cell,inventory.getMaxOccupency());
				            cell = row.createCell(priceCell);
				            insertCellValue(cell,inventory.getPrice());
				        }
			        }
		        }
	        }
	        File file = File.createTempFile("room_configuration", ".xlsx");
	        FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
            return file;
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("End DataExportHelper");
		return null;
	}

	private void insertCellValue(Cell cell, Object obj) {
		if(obj != null){
			if(obj instanceof String)
	             cell.setCellValue((String)obj);
	        else if(obj instanceof Integer)
	             cell.setCellValue((Integer)obj);
	        else if(obj instanceof Double)
	             cell.setCellValue((Double)obj);
		} 
		
	}
	
	public void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
  
}
	
}
