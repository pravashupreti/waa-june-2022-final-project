import React from 'react';
import ReactECharts from 'echarts-for-react';
import NumberOfStudents from './charts/NumberOfStudents';
import NumberOfJobs from './charts/NumberOfJobs';
import JobSearchTime from './charts/JobSearchTime';
import TagPieChart from './charts/TagPieChart';


function Dashboard() {

    const option = {

    };


    return (<div className='container'>



        <div className='row'>


            <div className='col-md-6'>
                <NumberOfJobs />
            </div>

            <div className='col-md-6'>

                <JobSearchTime />
            </div>
        </div>


        <div className='row'>

            <div className='col-md-6'>

                <NumberOfStudents />
            </div>

            <div className='col-md-6'>

                <TagPieChart />
            </div>

        </div>
    </div>);
}

export default Dashboard;