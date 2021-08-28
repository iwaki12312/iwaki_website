package controllers.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Music;
import utils.DBUtil;
import utils.Search;

/**
 * Servlet implementation class ManagementIndexServlet
 */
@WebServlet("/management/index")
public class ManagementIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagementIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//DB接続用のオブジェクト作成
		EntityManager em = DBUtil.createEntityManager();

		//Music格納用のリスト作成
		List<Music> musics = new ArrayList<Music>();

		//検索ワードの格納用変数
		String searchWord = null;

		//ページャ用の変数
		int page = 1;

		//ページャ用のパラメータを変数に格納
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
        	e.printStackTrace();
        }

        //検索用パラメータを変数に格納
        try{
        	searchWord = request.getParameter("search");
        } catch (Exception e) {
        	e.printStackTrace();
        }

		//全てのMusicを取得
//				musics = em.createNamedQuery("getAllMusic", Music.class)
//						.setFirstResult(3 * (page - 1))
//						.setMaxResults(3)
//						.getResultList();

        //検索結果をmusicsに格納(検索ワードが無ければ全件格納)
        musics = Search.searchMusic(searchWord,page);

		//Musicの件数を取得
        //int count = Integer.parseInt(String.valueOf(Search.getMusicCount(searchWord)));
        int musics_count = Math.toIntExact(Search.getMusicCount(searchWord));

		//DB接続を解除
		em.close();

		//全てのMusicをJSPに渡す
		request.setAttribute("musics",musics);
		//Musicの全件数をJSPに渡す
		request.setAttribute("musics_count",musics_count);
		//ページャ用のパラメータをJSPに渡す
		request.setAttribute("page", page);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/management/index.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
