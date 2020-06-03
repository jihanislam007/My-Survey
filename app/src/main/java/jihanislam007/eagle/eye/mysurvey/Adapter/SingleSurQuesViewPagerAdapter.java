package jihanislam007.eagle.eye.mysurvey.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jihanislam007.eagle.eye.mysurvey.Adapter.Model.singleSurveyQues;
import jihanislam007.eagle.eye.mysurvey.Adapter.Model.viewPagerDataModel;
import jihanislam007.eagle.eye.mysurvey.R;
import jihanislam007.eagle.eye.mysurvey.UserInfoActivity;


public class SingleSurQuesViewPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<singleSurveyQues> sliderImg;
  //  private ImageLoader imageLoader;


    public SingleSurQuesViewPagerAdapter(Context context, ArrayList sliderImg ) {
        this.context = context;
        this.sliderImg = sliderImg;
    }

    private final int limit = 3;
    @Override
    public int getCount() {
        /*if(sliderImg.size()>limit){
            return limit;
        }else*/
            return sliderImg.size();
        //return sliderImg.size();
    }


    @Override
    public boolean isViewFromObject(View collection, Object object) {
     //   return collection == ((View) object);
        return collection.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup  collection, final int position) {
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_survey_single_question, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_image);
        TextView tv_question = view.findViewById(R.id.tv_question);
        TextView tv_optionOne = view.findViewById(R.id.tv_optionOne);
        TextView tv_optionTwo = view.findViewById(R.id.tv_optionTwo);
        TextView tv_optionThree = view.findViewById(R.id.tv_optionThree);
        TextView tv_optionFour = view.findViewById(R.id.tv_optionFour);

        tv_question.setText(sliderImg.get(position).getQuestion());
        tv_optionOne.setText(sliderImg.get(position).getOptionOne());
        tv_optionTwo.setText(sliderImg.get(position).getOptionTwo());
        tv_optionThree.setText(sliderImg.get(position).getOptionThree());
        tv_optionFour.setText(sliderImg.get(position).getOptionFour());
       // TV_date.setText(sliderImg.get(position).getDate());

        /*Glide.with(context)
                .load(sliderImg.get(position).getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);*/
        /*try {
            Glide.with(context)
                    .load(sliderImg.get(position).getImageUrl())
                    .error(R.drawable.rectangular_shape_bacground)
                    .into(imageView);
        } catch (Exception e1) {
            e1.printStackTrace();
        }*/

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // context.startActivity(new Intent(context, UserInfoActivity.class));

                /*Bundle bundle=new Bundle();
                bundle.putInt("category_id",sliderImg.get(position).id);

                bundle.putString("TitleName",sliderImg.get(position).getTitle());
                bundle.putString("DetailsNews",sliderImg.get(position).getNews());
                bundle.putString("Date",sliderImg.get(position).getDate());
                bundle.putString("CategoryImage",sliderImg.get(position).getImageURL());

                NewsViewFragment newsViewFragment = new NewsViewFragment();
                //        GalleryFragment galleryFragment = new GalleryFragment();
                newsViewFragment.setArguments(bundle);
                FragmentTransaction fragTransaction = ((HomeActivity)context).getSupportFragmentManager().beginTransaction();
                fragTransaction.replace(R.id.nav_host_fragment,newsViewFragment );
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();*/

                /*if(position == 0){
                    Bundle bundle=new Bundle();
                    bundle.putInt("category_id",girlsPlays.get(position).id);

                    bundle.putString("TitleName",girlsPlays.get(position).getTitle());
                    bundle.putString("DetailsNews",girlsPlays.get(position).getNews());
                    bundle.putString("Date",girlsPlays.get(position).getDate());
                    bundle.putString("CategoryImage",girlsPlays.get(position).getImageURL());

                    NewsViewFragment newsViewFragment = new NewsViewFragment();
                    //        GalleryFragment galleryFragment = new GalleryFragment();
                    newsViewFragment.setArguments(bundle);
                    FragmentTransaction fragTransaction = ((HomeActivity)context).getSupportFragmentManager().beginTransaction();
                    fragTransaction.replace(R.id.nav_host_fragment,newsViewFragment );
                    fragTransaction.addToBackStack(null);
                    fragTransaction.commit();

                 //   Toast.makeText(context, "Slide 1 Clicked", Toast.LENGTH_SHORT).show();
                } else if(position == 1){
                    Toast.makeText(context, "Slide 2 Clicked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Slide 3 Clicked", Toast.LENGTH_SHORT).show();
                }*/

            }
        });




        ((ViewPager) collection).addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(View collection, int position, Object view) {
        ((ViewPager) collection).removeView((View) view);
    }



}
