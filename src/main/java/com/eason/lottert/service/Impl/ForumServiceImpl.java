package com.eason.lottert.service.Impl;

import com.eason.lottert.bean.Note;
import com.eason.lottert.dao.ForumDao;
import com.eason.lottert.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

/**
 * @ 文件名:   ForumServiceImpl
 * @ 创建者:   Eason
 * @ 时间:    2018/9/30 17:03
 * @ 描述:
 */
@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    private ForumDao forumDao;

    @Override
    public void uploadNote(Note note) {
        forumDao.save(note);
    }

    @Override
    public List<Note> findAll() {
        List<Note> notes = forumDao.findAll();
        notes.sort(new Comparator<Note>() {
            @Override
            public int compare(Note o1, Note o2) {
                long t1 = 0;
                long t2 = 0;
                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    t1 = dateFormat.parse(o1.getTime()).getTime();
                    t2 = dateFormat.parse(o2.getTime()).getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return (int) (t2 - t1);
            }
        });
        return notes;
    }

    @Override
    public Page<Note> findByPage(Integer pageNumber) {

        if (pageNumber == null) {
            pageNumber = 0;
        }

        int size = 10;
        Sort sort = new Sort(Sort.Direction.DESC, "time");

        Pageable pageable = new PageRequest(pageNumber, size, sort);
        return forumDao.findAll(pageable);
    }

    @Override
    public Note findByNid(String nid) {
        return forumDao.findByNid(nid);
    }
}
