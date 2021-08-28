package utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Music;

public class Search {

	//検索メソッド
	public static List<Music> searchMusic(String searchWord , int page) {

		//DB接続用のオブジェクト作成
		EntityManager em = DBUtil.createEntityManager();

		//Music格納用のリスト作成
		List<Music> musics = new ArrayList<Music>();

		//検索パラメータが存在しない場合全てのデータを検索
		if(searchWord == null || searchWord.equals("")){
			musics = em.createNamedQuery("getAllMusics", Music.class)
                    .setFirstResult(5 * (page - 1))
                    .setMaxResults(5)
                    .getResultList();

        //検索パラメータが存在する場合検索文字列を含むデータを検索
        }else{
        	musics = em.createNamedQuery("getSrarchMusics", Music.class)
    				.setParameter("search", "%" + searchWord + "%")
                    .setFirstResult(5 * (page - 1))
                    .setMaxResults(5)
                    .getResultList();
        }

		//DB接続を解除
		em.close();

		return musics;

	}

	//件数取得メソッド
	public static Long getMusicCount (String searchWord) {

		//件数格納用の変数
		Long musics_count;

		//DB接続用のオブジェクト作成
		EntityManager em = DBUtil.createEntityManager();

		//検索パラメータが存在しない場合全てのMusicの件数を取得
		if (searchWord == null || searchWord.equals("")) {
			musics_count = (Long)em.createNamedQuery("getAllMusicCount", Long.class)
	                .getSingleResult();

        //検索パラメータが存在する場合検索文字列を含むMusicの件数を取得
        } else {
        	musics_count = (Long)em.createNamedQuery("getMusicCount", Long.class)
        			.setParameter("search", "%" + searchWord + "%")
                    .getSingleResult();
        }

		//DB接続を解除
		em.close();

		return musics_count;
	}

}
