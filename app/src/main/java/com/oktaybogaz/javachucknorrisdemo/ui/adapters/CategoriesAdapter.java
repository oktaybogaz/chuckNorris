package com.oktaybogaz.javachucknorrisdemo.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.oktaybogaz.javachucknorrisdemo.R;
import com.oktaybogaz.javachucknorrisdemo.ui.menu.MenuScreenContract;
import com.oktaybogaz.javachucknorrisdemo.ui.menu.MenuScreenPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>{
    private LayoutInflater inflater;
    private Context context;
    private List<String> categoriesList;
    private OnRowClickListener onRowClickListener;

    public CategoriesAdapter(Context context) {
        this.categoriesList = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesViewHolder(inflater.inflate(R.layout.row_categories, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {

        String categoryName = categoriesList.get(position);
        holder.tvCategoryName.setText(categoryName);

        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public void updateAdapter(List<String> categories) {
        this.categoriesList.addAll(categories);
    }

    public void setOnRowClickListener(OnRowClickListener onRowClickListener) {
        this.onRowClickListener = onRowClickListener;
    }

    protected class CategoriesViewHolder extends RecyclerView.ViewHolder {

        int position;

        @BindView(R.id.tvCategoryName)
        AppCompatTextView tvCategoryName;

        @OnClick(R.id.clCategoriesRow)
        public void onRowClicked() {

            onRowClickListener.onRowclickListener(categoriesList.get(position).toString());
        }

        public CategoriesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnRowClickListener {

        void onRowclickListener(String categoryName);

    }
}

