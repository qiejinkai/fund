package cn.efunding.fund.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.efunding.fund.R;
import cn.efunding.fund.entity.XSubject;

/**
 * Created by qiejinkai on 16/4/7.
 */
public class SubjectXAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<XSubject> subjectXList;

    public List<XSubject> getSubjectXList() {
        return subjectXList;
    }

    public void setSubjectXList(List<XSubject> subjectXList) {
        this.subjectXList = subjectXList;
    }

    public SubjectXAdapter(Context context,List<XSubject>subjectXList ) {
        this.layoutInflater = LayoutInflater.from(context);
        this.subjectXList = subjectXList;
        this.context = context;
    }
    @Override
    public int getCount() {
        return subjectXList.size();
    }

    @Override
    public Object getItem(int position) {
        return subjectXList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = layoutInflater.inflate(R.layout.subject_x_module,null);
        }

        XSubject xSubject = (XSubject)subjectXList.get(position);

        TextView title = (TextView) convertView.findViewById(R.id.tvXSubjectName);
        title.setText("新手专享");
        title.setTextColor(convertView.getResources().getColor(R.color.fund_white));

        TextView title2 = (TextView) convertView.findViewById(R.id.tvXSubjectName2);
        title2.setText(xSubject.getName());
        TextView uCount = (TextView) convertView.findViewById(R.id.tvXSubjectUCount);
        uCount.setTextColor(convertView.getResources().getColor(R.color.fund_white));
        uCount.setText(xSubject.getuCount()+"人已加入");

        TextView yeild= (TextView) convertView.findViewById(R.id.tvXSubjectYeild);
        yeild.setTextColor(convertView.getResources().getColor(R.color.fund_yellow));
        yeild.setText((xSubject.getYield() / 100) + "");

        TextView closedDays = (TextView) convertView.findViewById(R.id.tvXSubjectClosedDays);
        closedDays.setText(xSubject.getClosedDays()+"天");

        TextView interestDays = (TextView) convertView.findViewById(R.id.tvXSubjectInterestDays);
        interestDays.setText("T+"+xSubject.getInterestDays()+"计息");


        TextView percent= (TextView) convertView.findViewById(R.id.tvXSubjectYeildPercent);
        percent.setTextColor(convertView.getResources().getColor(R.color.fund_yellow));
        return convertView;
    }
}
