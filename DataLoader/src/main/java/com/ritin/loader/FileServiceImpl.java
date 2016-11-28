package com.ritin.loader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;



import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.BodyPartEntity;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataParam;


import com.ritin.helper.FileServiceHelper;



 
@Path("/file")
public class FileServiceImpl {
	
	@GET
	@Path("/downloadDigitalAsset")
	@Produces("application/vnd.ms-excel")
	public Response  exportData() {
		FileServiceHelper helper = new FileServiceHelper();
		ResponseBuilder response = null;
		File  file = helper.exportToExcel();
		if(file!=null){
			response = Response.ok((Object) file);
			response.header("Content-Disposition",	"attachment; filename=room_configuration.xlsx");
			return response.build();
		}
		return null;
	}
	
	  @POST
	  @Path("/uploadDigitalAsset")
	  @Consumes(MediaType.MULTIPART_FORM_DATA)
	  public Response uploadImages(@DefaultValue("") @FormDataParam("tags") String tags,
				@FormDataParam("file") List<FormDataBodyPart> bodyParts,
				@FormDataParam("file") FormDataContentDisposition fileDispositions)
	  {

		  FileServiceHelper helper = new FileServiceHelper();
			StringBuffer fileDetails = new StringBuffer("");

			// Save multiple files 

			for (int i = 0; i < bodyParts.size(); i++) {
				
				BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
				String fileName = bodyParts.get(i).getContentDisposition().getFileName();
				String uploadedFileLocation = "d://"+ fileName;
				System.out.println("uploaded filenames>>>>"+fileName); 
				helper.writeToFile(bodyPartEntity.getInputStream(), uploadedFileLocation);
				fileDetails.append("File uploaded to : " + uploadedFileLocation);
			}
			return Response.ok(fileDetails.toString()).build();
	  }
	  
	 /* @POST
	  @Path("/uploadDigitalAsset")
	  @Consumes({MediaType.MULTIPART_FORM_DATA})
	  public Response uploadPdfFile(  @FormDataParam("file") InputStream fileInputStream,
	                                  @FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception
	  {
	      String UPLOAD_PATH = "c:/temp/";
	      try
	      {
	          int read = 0;
	          byte[] bytes = new byte[1024];
	   
	          OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + fileMetaData.getFileName()));
	          while ((read = fileInputStream.read(bytes)) != -1) 
	          {
	              out.write(bytes, 0, read);
	          }
	          out.flush();
	          out.close();
	      } catch (IOException e) 
	      {
	          e.printStackTrace();
	      }
	      return Response.ok("Data uploaded successfully !!").build();
	  }*/
	  
	  
	
}
