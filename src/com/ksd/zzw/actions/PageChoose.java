package com.ksd.zzw.actions;

import com.ksd.zzw.entity.*;
import com.ksd.zzw.service.*;
import com.ksd.zzw.util.UtilPage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class PageChoose extends ActionSupport implements ServletRequestAware {

    /**
     *
     */
    private static final long serialVersionUID = 4407244928547036758L;

    protected String select;
    protected Integer pageSize;
    protected Integer currentPageNo;

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(Integer currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    @Resource(name = "addressService")
    private AddressService addressService;
    @Resource(name = "meetingService")
    private MeetingService meetingService;
    @Resource(name = "noticeService")
    private NoticeService noticeService;
    @Resource(name = "scheduleService")
    private ScheduleService scheduleService;
    @Resource(name = "smsService")
    private SmsService smsService;
    @Resource(name = "worklogService")
    private WorklogService worklogService;

    public UtilPage page = new UtilPage();

    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String select() {
//        System.out.println("******************************"+pageSize+"*******"+select+"*****"+currentPageNo);
        if (pageSize != null && pageSize != 0)
            page.setPageSize(pageSize);
        if (currentPageNo != null && currentPageNo != 0)
            page.setCurrentPageNo(currentPageNo);

        ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        User user = (User) session.get("user");
        if (user == null) return "error";
        String username = user.getUsername();
        String result = "";
        Integer totalCount = 0;
        if ("0".equals(select)) {
            return "MainPage";
        } else if ("1".equals(select)) {
            totalCount = addressService.getAllCount(username);
            List list = addressService.getPageAddress(username, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            request.setAttribute("addressList", list);

            result = "Address";
        } else if ("2".equals(select)) {
            totalCount = meetingService.getAllCount(username);
            List<Meeting> list = meetingService.getMeetingPage(username, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            request.setAttribute("meetingList", list);

            result = "Meeting";
        } else if ("3".equals(select)) {
            totalCount = noticeService.getAllCount(username);
            List<Notice> list = noticeService.getNoticePage(username, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            request.setAttribute("noticeList", list);

            result = "Notice";
        } else if ("4".equals(select)) {
            totalCount = scheduleService.getAllCount(username);
            List<Schedule> list = scheduleService.getSchedulePage(username, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            request.setAttribute("scheduleList", list);

            result = "Schedule";
        } else if ("5".equals(select)) {
            totalCount = smsService.getAllCount(username);
            List<Sms> list = smsService.getSmsPage(username, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            request.setAttribute("smsList", list);

            result = "Sms";
        } else if ("6".equals(select)) {
            totalCount = worklogService.getAllCount(username);
            List<Worklog> list = worklogService.getWorklogPage(username, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            request.setAttribute("worklogList", list);

            result = "Worklog";
        } else {
            result = "MainPage";
        }

        if ("MainPage".equals(result))
            return result;

        page.setTotalCount(totalCount);
        request.setAttribute("pageSize", page.getPageSize());
        request.setAttribute("currentPageNo", page.getCurrentPageNo());
        request.setAttribute("totalCount", page.getTotalCount());
        request.setAttribute("totalPageCount", page.getTotalPageCount());

        return result;
    }

}
