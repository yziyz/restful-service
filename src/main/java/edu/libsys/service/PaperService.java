package edu.libsys.service;

import edu.libsys.conf.Conf;
import edu.libsys.data.dao.PaperDao;
import edu.libsys.entity.Paper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.LinkedList;
import java.util.List;

@Path("papers")
@Provider
@Produces({"application/x-javascript;charset=UTF-8", "application/json;charset=UTF-8"})
public class PaperService {

    //Paper数据访问对象
    private final PaperDao paperDao = new PaperDao();

    //添加
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int addPaper(final Paper paper) {
        return paperDao.addPaper(paper);
    }

    //删除
    @Path("{id:[0-9]*}")
    @DELETE
    public int deletePaper(@PathParam("id") final int id) {
        return paperDao.deletePaper(id);
    }

    //更新
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public int updateBook(final Paper paper) {
        return paperDao.updatePaper(paper);
    }

    //获得单个
    @Path("{id:[0-9]*}")
    @GET
    public Paper getPaperById(@PathParam("id") final int id) {
        return paperDao.getPaperById(id);
    }

    //获得多个
    @Path("get")
    @GET
    @Produces({"application/x-javascript;charset=UTF-8", "application/json;charset=UTF-8"})
    public List<Paper> getPaperList(@QueryParam("page") final int page, @QueryParam("size") final int size) {
        return paperDao.getPaperList(page, size);
    }

    //关键词查询
    @Path("search")
    @GET
    @Produces({"application/x-javascript;charset=UTF-8", "application/json;charset=UTF-8"})
    public List<Paper> getPaperListBySearchTitle(@QueryParam("keyword") final String keyword) {
        //如果检索关键词超出长度，返回空
        if (keyword.length() > Conf.MAX_LENGTH_OF_SEARCH_KEYWORD) {
            return null;
        }
        List<Paper> paperList = new LinkedList<>();
        paperList.addAll(paperDao.getPaperListBySearchTitle(keyword));
        //较费时间，暂时关闭
        //paperList.addAll(paperDao.getPaperListBySearchIntro(keyword));
        //paperList.addAll(paperDao.getPaperListBySearchSearchWord(keyword));
        return paperList;
    }
}
