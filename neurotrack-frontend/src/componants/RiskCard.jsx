export default function RiskCard({ risk }) {
  return (
    <div className="bg-red-100 p-6 rounded-xl shadow-lg">
      <h2 className="text-xl font-bold">Risk Level</h2>
      <p className="text-2xl mt-2">{risk}</p>
    </div>
  );
}