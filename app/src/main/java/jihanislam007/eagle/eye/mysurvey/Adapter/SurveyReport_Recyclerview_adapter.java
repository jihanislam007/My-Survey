package jihanislam007.eagle.eye.mysurvey.Adapter;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

import jihanislam007.eagle.eye.mysurvey.Adapter.Model.SurveyReport;
import jihanislam007.eagle.eye.mysurvey.DB.Model.UserInfo;
import jihanislam007.eagle.eye.mysurvey.R;


public class SurveyReport_Recyclerview_adapter extends RecyclerView.Adapter<SurveyReport_Recyclerview_adapter.myViewHolder>{

    Context mcontext;
    ArrayList<SurveyReport> categoryList;

    public SurveyReport_Recyclerview_adapter(Context context, ArrayList<SurveyReport> categoryList){
        this.mcontext = context;
        this.categoryList = categoryList;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_survey_report,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {


        /*Glide.with(mcontext)
                .load(categoryList.get(position).getCategoryImage())
                .centerCrop()
                .placeholder(R.drawable.demo)
                .into(holder.CategoryItemImageView);*/
        //Glide.with(mcontext).load(categoryList.get(position).getLayoutImageURL()).into(holder.backgroundImageView);
        /*Glide.with(mcontext)
                .load(categoryList.get(position).getCategoryImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.backgroundImageView);
*/
        //  Log.e("image",categoryList.get(position).getCategoryImage());

        holder.userMobile.setText(categoryList.get(position).getReport_mobile());
        holder.userGender.setText(categoryList.get(position).getReport_gender());
        holder.userAge.setText(categoryList.get(position).getReport_age());

    //    holder.a1.setText(categoryList.get(position).getQ_one());
        /*holder.a2.setText(categoryList.get(position).getQ2());
        holder.a3.setText(categoryList.get(position).getQ3());
        holder.a4.setText(categoryList.get(position).getQ4());
        holder.a5.setText(categoryList.get(position).getQ5());*/

    //    holder.catagoryCounterTV.setText(String.valueOf(categoryList.get(position).getCounter()));

        /*holder.backgroundImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();

                bundle.putInt("category_id",categoryList.get(position).CategoryId);

                bundle.putString("category_name",categoryList.get(position).getCategoryName());
                bundle.putString("CategoryImage",categoryList.get(position).getCategoryImage());

                RecipeListFragment recipeListFragment = new RecipeListFragment();
                recipeListFragment.setArguments(bundle);
                //   Toast.makeText(mcontext, "Image :"+String.valueOf(bundle), Toast.LENGTH_SHORT).show();
                FragmentTransaction fragTransaction = ((DashBoardActivity)mcontext).getSupportFragmentManager().beginTransaction();
                fragTransaction.replace(R.id.frag_container,recipeListFragment );
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();
            }
        });*/


        /*holder.backgroundLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle=new Bundle();
                bundle.putInt("category_id",categoryList.get(position).CategoryId);

                bundle.putString("category_name",categoryList.get(position).getCategoryName());
                bundle.putString("CategoryImage",categoryList.get(position).getCategoryImage());

                RecipeListFragment recipeListFragment = new RecipeListFragment();
                recipeListFragment.setArguments(bundle);
                //   Toast.makeText(mcontext, "Image :"+String.valueOf(bundle), Toast.LENGTH_SHORT).show();
                FragmentTransaction fragTransaction = ((DashBoardActivity)mcontext).getSupportFragmentManager().beginTransaction();
                fragTransaction.replace(R.id.frag_container,recipeListFragment );
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();

            }
        });*/


    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout backgroundLinearLayout;
        TextView userMobile,userGender,userAge;
        TextView a1,a2,a3,a4,a5;
        ImageView backgroundImageView,CategoryItemImageView;

        public myViewHolder(View itemView) {
            super(itemView);


            /*backgroundLinearLayout = itemView.findViewById(R.id.backgroundLinearLayout);
            backgroundImageView = itemView.findViewById(R.id.backgroundImageView);
            categoryItemNameTV = itemView.findViewById(R.id.categoryItemNameTV);*/
            userMobile = itemView.findViewById(R.id.User_tv_mobile);
            userGender = itemView.findViewById(R.id.User_tv_gender);
            userAge = itemView.findViewById(R.id.User_tv_age);

            a1 = itemView.findViewById(R.id.a1);
            a2 = itemView.findViewById(R.id.a2);
            a3 = itemView.findViewById(R.id.a3);
            a4 = itemView.findViewById(R.id.a4);
            a5 = itemView.findViewById(R.id.a5);


        }

        @Override
        public void onClick(View view) {

        }
    }
}