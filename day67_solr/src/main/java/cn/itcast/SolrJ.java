package cn.itcast;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

public class SolrJ {


    @Test
    public  void test() {
        System.out.println("这是Coder A提交的代码,注意查收");

        System.out.println("这是Coder A第二次提交代码 -0-");
    }

    @Test
    public  void test1() {
        System.out.println("这是Coder B提交的代码,注意查收");
    }

    /**
     * 需求: 添加及更新索引库
     *  特点:
     *      1.如果索引库文档id存在表示更新
     *      2.如果索引库文档id不存在表示添加
     */
    @Test
    public void addIndex() throws IOException, SolrServerException {
        //指定solr远程服务器连接地址
        //注意：
        //如果索引库名称没有修改，还叫collection1,此时连接路径不需要指定索引库名称
        //否则必须指定索引库名称
        String url = "http://localhost:8080/solr/products";
        //创建连接solr服务核心对象
        SolrServer solrServer = new HttpSolrServer(url);

        //创建文档对象
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id","u110");
        doc.addField("name","周芷若");

        //写入索引库
        solrServer.add(doc);
        //提交
        solrServer.commit();
    }

    @Test
    public void deleteIndex() throws IOException, SolrServerException {

        //指定solr远程服务器连接地址
        //注意：
        //如果索引库名称没有修改，还叫collection1,此时连接路径不需要指定索引库名称
        //否则必须指定索引库名称
        String url = "http://localhost:8080/solr/products";
        //创建连接solr服务核心对象
        SolrServer solrServer = new HttpSolrServer(url);

        //1,根据id删除
        //solrServer.deleteById("u110");

        //2,根据查询语法删除
        solrServer.deleteByQuery("id:u110");

        //3.删除所有
        solrServer.deleteByQuery("*:*");
        solrServer.commit();
    }
}
